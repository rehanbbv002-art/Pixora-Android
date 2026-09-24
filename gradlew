#!/usr/bin/env sh

# Resolving links from the command's name
PRG="$0"
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`/"$link"
    fi
done

PRGDIR=`dirname "$PRG"`
APP_BASE_NAME=`basename "$0"`
APP_HOME="`cd "$PRGDIR" >/dev/null; pwd .`"

# Collect all arguments
JAVA_OPTS="$JAVA_OPTS"

