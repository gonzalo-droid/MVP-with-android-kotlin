package com.hackaprende.mvpiano

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hackaprende.mvpiano.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.songRecycler
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = SongAdapter()
        adapter.setOnItemClickListener {
            Toast.makeText(this, it.chords, Toast.LENGTH_SHORT).show()
        }

        recycler.adapter = adapter

        val songList = downloadSongs()
        adapter.submitList(songList)
    }

    private fun downloadSongs(): MutableList<Song> {
        val songList = mutableListOf<Song>()

        songList.add(Song(1, "Für Elise", "Ludwig Van Bethoven", "Do re mi fa sol"))
        songList.add(Song(2, "Spring", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(3, "Summer", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(4, "Autumn", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(5, "Winter", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(6, "Canon in D", "Pachelbel", "Do re mi fa sol"))
        songList.add(Song(7, "Claire de lune", "Debussy", "Do re mi fa sol"))
        songList.add(Song(8, "Moonlight sonata", "Ludwig Van Bethoven", "Do re mi fa sol"))

        return songList
    }
}