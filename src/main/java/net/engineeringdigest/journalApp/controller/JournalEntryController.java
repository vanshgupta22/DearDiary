package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllJournals();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){
        return journalEntryService.addJournal(entry);
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntryById(myId);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteJournalEntry(@PathVariable ObjectId id){
        journalEntryService.removeJournal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("id/{id}")
//    public ResponseEntity<?> editEntry(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
//        Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntryById(id);
//        if(journalEntry.isPresent()){
//            journalEntry.setTitle("abc");
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//
//    }



}
