package com.example.demo.utilities.repository.migration;

record Migration (
        int from,
        int to,
        MigrationAction action
){}
