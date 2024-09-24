package com.kamau.nexchat.model

data class Channel(
  val id: String = "",
  val name: String,
  val createdAt: Long = System.currentTimeMillis()
)