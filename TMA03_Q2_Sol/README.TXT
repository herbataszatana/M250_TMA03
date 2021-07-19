//a(iii)
Builder builder = new Builder();

builder.addContractor("ABC1234", "Stan", "Stirling", "Joiner");
builder.addContractor("ABC1235", "Jake", "Glasgow", "Electritian");
builder.addContractor("ABC1236" ,"Joe", "Edinburgh", "Decorator");
builder.addContractor("ABC1237" ,"Mike", "Edinburgh", "Decorator");

//a(iv)

builder.printContractors();

//b 

//existing
builder.findContractor("ABC1234");
//non-existing
builder.findContractor("ABC0000");

//c
builder.findContractorsForTrade("Joiner");
