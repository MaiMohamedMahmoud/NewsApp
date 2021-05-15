package com.codinginflow.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codinginflow.mvvmnewsapp.databinding.ActivityMainBinding
import com.codinginflow.mvvmnewsapp.feature.bookmarks.BookmarksFragment
import com.codinginflow.mvvmnewsapp.feature.breakingnews.BreakingNewsFragment
import com.codinginflow.mvvmnewsapp.feature.searchnews.SearchNewsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var breakingNewsFragment: BreakingNewsFragment
    lateinit var bookmarksFragment: BookmarksFragment
    lateinit var searchNewsFragment: SearchNewsFragment

    // (get =) used because it will only initialize when accessed
    //so we make sure it will be after BreakingNewsFragment is initialize.
    private val fragments: Array<Fragment>
        get() = arrayOf(
            breakingNewsFragment,
            bookmarksFragment,
            searchNewsFragment
        )
    private var selectedIndex = 0
    private val selectedFragment = fragments[selectedIndex]

    private fun selectFragment(selectedFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        fragments.forEachIndexed { index, fragment ->
            if (selectedFragment == fragment) {
                transaction.attach(selectedFragment)
                selectedIndex = index
            } else {
                transaction.detach(selectedFragment)
            }
        }
        transaction.commit()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            //here we add the fragments.
            breakingNewsFragment = BreakingNewsFragment()
            bookmarksFragment = BookmarksFragment()
            searchNewsFragment = SearchNewsFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, breakingNewsFragment, TAG_BREAKING_NEWS_FRAGMENT)
                .add(R.id.fragment_container, bookmarksFragment, TAG_BOOKMARK_FRAGMENT)
                .add(R.id.fragment_container, searchNewsFragment, TAG_SEARCH_NEWS_FRAGMENT)
                .commit()
            selectFragment(selectedFragment)
        } else {
            breakingNewsFragment = supportFragmentManager.findFragmentByTag(
                TAG_BREAKING_NEWS_FRAGMENT
            ) as BreakingNewsFragment
            bookmarksFragment = supportFragmentManager.findFragmentByTag(
                TAG_BOOKMARK_FRAGMENT
            ) as BookmarksFragment
            bookmarksFragment = supportFragmentManager.findFragmentByTag(
                TAG_BOOKMARK_FRAGMENT
            ) as BookmarksFragment
            selectedIndex = savedInstanceState.getInt(KEY_SELECTED_INDEX, 0)
        }
        selectFragment(selectedFragment)

        binding.navBottom.setOnNavigationItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_breaking -> breakingNewsFragment
                R.id.nav_search -> searchNewsFragment
                R.id.nav_bookmarks -> bookmarksFragment
                else -> throw IllegalArgumentException("Unexpected itemId")
            }

            selectFragment(fragment)
            true
        }
    }

    override fun onBackPressed() {
        if (selectedIndex != 0) {
            binding.navBottom.selectedItemId = R.id.nav_breaking
        } else {
            super.onBackPressed()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SELECTED_INDEX, 0)
    }
}

private const val TAG_BREAKING_NEWS_FRAGMENT = "TAG_BREAKING_NEWS_FRAGMENT"
private const val TAG_BOOKMARK_FRAGMENT = "TAG_BOOKMARK_FRAGMENT"
private const val TAG_SEARCH_NEWS_FRAGMENT = "TAG_SEARCH_NEWS_FRAGMENT"
private const val KEY_SELECTED_INDEX = "KEY_SELECTED_INDEX"