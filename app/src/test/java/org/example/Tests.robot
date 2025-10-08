*** Settings ***
Library    Remote    http://localhost:8270/MemoryLibrary
Library    BuiltIn

*** Test Cases ***
Check RAM Slots
    ${rams}=    Remote.Get Processed Data As Strings
    Log    ${rams}    console=True
    Should Match Some    ${rams}    *DDR4*
