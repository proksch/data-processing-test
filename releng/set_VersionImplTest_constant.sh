#!/bin/bash
V=$1
TEST=`find . -name "VersionImplTest.java"`
sed "s/CURRENT_VERSION = \"[^\"]*\"/CURRENT_VERSION = \"${V}\"/" $TEST
