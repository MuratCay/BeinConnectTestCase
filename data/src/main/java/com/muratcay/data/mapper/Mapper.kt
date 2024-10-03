package com.muratcay.data.mapper

interface Mapper<E, D> {
    fun mapToModel(type: E): D
}