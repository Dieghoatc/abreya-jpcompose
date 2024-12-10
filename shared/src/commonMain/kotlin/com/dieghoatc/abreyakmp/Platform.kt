package com.dieghoatc.abreyakmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform