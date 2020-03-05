package com.example.customizecars


class DBSchema {
    internal object AccountsTable {
        val TABLENAME = "accounts"

        internal object Cols {
            val ACCTNO = "acctnumber"
            val NAME = "name"
            val PASSWORD = "password"
        }
    }

    internal object UsersTable {
        val TABLENAME = "users"

        internal object Cols {
            val NAME = "name"
            val ADDRESS = "address"
            val PHONE = "phone"
            val EMAIL = "email"
            val USERACCTNO = "useracctno"
        }
    }

    internal object CustomizesTable {
        val TABLENAME = "customizs"

        internal object Cols {
            val SAVEID = "saveid"
            val CUSACCTNO = "cusacctno"
        }
    }


    internal object CartypesTable {
        val TABLENAME = "cartypes"

        internal object Cols {
            val NAME = "name"
        }
    }

    internal object LocationsTable {
        val TABLENAME = "locations"

        internal object Cols {
            val NAME = "name"
            val ADDRESS = "address"
            val PHONE = "phone"
            val EMAIL = "email"
            val CARTYPENAME = "cartypename"
        }
    }


    internal object ModelsTable {
        val TABLENAME = "models"

        internal object Cols {
            val NAME = "name"
            val MODELNO = "modelno"
            val CARTYPENAME = "cartypename"
        }
    }


    internal object ColorsTable {
        val TABLENAME = "colors"

        internal object Cols {
            val NAME = "name"
            val SAVEID = "saveid"
            val MODLENAME = "modelname"
        }
    }


    internal object ExteriorsTable {
        val TABLENAME = "exteriors"

        internal object Cols {
            val EXTERIORID = "exteriorid"
            val WHEEL = "wheel"
            val BUMPER = "bumper"
            val ENGINE = "engine"
            val SAVEID = "saveid"
        }
    }


    internal object InteriorsTable {
        val TABLENAME = "interiors"

        internal object Cols {
            val INTERIORID = "interiorid"
            val DASHBOARD = "dashboard"
            val SUNROOF = "sunroof"
            val SCREENSIZE = "screensize"
            val SAVEID = "saveid"
        }
    }
}
