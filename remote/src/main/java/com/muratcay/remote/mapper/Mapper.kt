package com.muratcay.remote.mapper

interface Mapper<E, D> {
    fun mapToModel(type: E): D
}