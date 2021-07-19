------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: TMA03 Q3 
PURPOSE OF PROJECT: To pass M250 
VERSION or DATE: 21/04/21
HOW TO START THIS PROJECT: with creating new Office object
AUTHORS: Anna Duncan
USER INSTRUCTIONS:

To check all the methods please execute below codes. 

// to create new map
Office branches = new Office();

//Q3 b 2
branches.addEmployee()();

//Q3 c
branches.printMap();

//Q3 c    
   //when the key matches
   branches.printMapValue("Scranton"); 
   
   //when key doesn't match
   branches.printMapValue("scranton"); 
   
//Q3 c
   
   //Non existing key
   branches.addMapEntry("New york", "Lucile Bluth");

   //Existing key
   branches.addMapEntry("New york", "Lucile 2");

//Q3 d deleteEntry(String localisation)
branches.deleteEntry("Philadelphia");

//Q3 d addToValueAtKey(String office, String name) 
branches.addToValueAtKey("Scranton", "Lucile Bluth");

//Q3 d deleteFromValueAtKey(String office, String value)
branches.deleteFromValueAtKey("Scranton", "Pam Beesly");