*** Settings ***
Library     Remote      http://localhost:8270/MemoryLibrary

*** Test Cases ***
Check RAM Slots
    ${rams}=    Remote.Get Processed Memory Data As Strings
    Log     ${rams}
    Should Contain      ${rams}     DDR4