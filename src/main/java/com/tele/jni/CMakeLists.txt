cmake_minimum_required(VERSION 3.0 FATAL_ERROR)

project (testJni)

add_library(${PROJECT_NAME} SHARED testJni.cpp)

