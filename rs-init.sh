#!/bin/bash

mongosh <<EOF
var config = {
    "_id": "rs0",
    "version": 1,
    "members": [
        {
            "_id": 0,
            "host": "mongo1:27017",
            "priority": 2
        },
        {
            "_id": 1,
            "host": "mongo2:27017",
            "priority": 1
        },
        {
            "_id": 2,
            "host": "mongo3:27017",
            "priority": 1
        }
    ]
};
rs.initiate(config);
EOF