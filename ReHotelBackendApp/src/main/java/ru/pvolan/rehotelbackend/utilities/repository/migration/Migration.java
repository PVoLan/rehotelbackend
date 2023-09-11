package ru.pvolan.rehotelbackend.utilities.repository.migration;

record Migration (
        int from,
        int to,
        MigrationAction action
){}
