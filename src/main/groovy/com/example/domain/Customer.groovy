package com.example.domain

import groovy.transform.Canonical

@Canonical
class Customer implements Serializable {
    Integer id
    String firstName
    String lastName
}
