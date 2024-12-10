package com.dieghoatc.abreyakmp.android.ui.sreens.technical

class TechnicialViewModel {
    
    data class Technician(
        val id: Int,
        val name: String,
        val lastName: String,
        val email: String,
        val phoneNumber: String,
        val sector: String,
        val service: String,
        val image: String
    )

    data class ListTechnical(
        val technicians: List<Technician>
    )
}