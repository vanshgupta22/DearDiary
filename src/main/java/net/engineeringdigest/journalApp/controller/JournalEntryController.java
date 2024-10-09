package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllJournals();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){
        return journalEntryService.addJournal(entry);
    }

//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
////        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping
//    public Boolean deleteJournalEntry(){
//
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry editEntry(@PathVariable ObjectId id){
//
//    }



}
