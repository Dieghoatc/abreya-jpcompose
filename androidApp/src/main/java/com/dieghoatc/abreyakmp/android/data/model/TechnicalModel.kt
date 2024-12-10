package com.dieghoatc.abreyakmp.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TechnicalModel(
    val id: String,
    val name: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val sector: String,
    val service: String,
    val image: String
)

data class ListTechnical(
    val technicians: List<TechnicalModel>
)

val techniciansList = ListTechnical(
    technicians = listOf(
        TechnicalModel(
            id = "1",
            name = "Diego",
            lastName = "Tejedor",
            email = "diego.tejedor@gmail.com",
            phoneNumber = "+56 987654321",
            sector = "Kennedy",
            service = "80.000",
            image = "https://picsum.photos/id/10/200/300"
        ),
        TechnicalModel(
            id = "2",
            name = "María Pérez",
            lastName = "Pérez",
            email = "maria.perez@gmail.com",
            phoneNumber = "+57 3001234567",
            sector = "Usaquen",
            service = "90.000",
            image = "https://picsum.photos/id/11/200/300"
        ),
        TechnicalModel(
            id = "3",
            name = "Juan García",
            lastName = "García",
            email = "juan.garcia@gmail.com",
            phoneNumber = "+57 3209876543",
            sector = "Bosa",
            service = "85.000",
            image = "https://picsum.photos/id/12/200/300"
        ),
        TechnicalModel(
            id = "4",
            name = "Ana González",
            lastName = "González",
            email = "ana.gonzalez@gmail.com",
            phoneNumber = "+56 987654321",
            sector = "Fontibon",
            service = "70.000",
            image = "https://picsum.photos/id/13/200/300"
        ),
        TechnicalModel(
            id = "5",
            name = "Diego",
            lastName = "Tejedor",
            email = "diego.tejedor@gmail.com",
            phoneNumber = "+56 987654321",
            sector = "Kennedy",
            service = "80.000",
            image = "https://picsum.photos/id/10/200/300"
        ),
        TechnicalModel(
            id = "6",
            name = "María Pérez",
            lastName = "Pérez",
            email = "maria.perez@gmail.com",
            phoneNumber = "+57 3001234567",
            sector = "Usaquen",
            service = "90.000",
            image = "https://picsum.photos/id/11/200/300"
        ),
        TechnicalModel(
            id = "7",
            name = "Juan García",
            lastName = "García",
            email = "juan.garcia@gmail.com",
            phoneNumber = "+57 3209876543",
            sector = "Bosa",
            service = "85.000",
            image = "https://picsum.photos/id/12/200/300"
        ),
        TechnicalModel(
            id = "8",
            name = "Ana González",
            lastName = "González",
            email = "ana.gonzalez@gmail.com",
            phoneNumber = "+56 987654321",
            sector = "Fontibon",
            service = "70.000",
            image = "https://picsum.photos/id/13/200/300"
        )
    )
)


