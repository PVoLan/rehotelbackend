package com.example.demo.utilities.repository.migration;

import com.example.demo.utilities.repository.migration.migrations.MigrationAction000to001;

import java.util.Arrays;
import java.util.List;

class Migrations {

    public static final int LAST_VERSION = 1;

    public static final List<Migration> migrations = Arrays.asList(
            new Migration(0, 1, new MigrationAction000to001())
    );
}
