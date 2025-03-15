package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//controller - handles the http requests
@RequestMapping("/journal")

public class JournalEntryController {
    private final Map<Long, JournalEntry> journalEntries= new HashMap<>();

@GetMapping("/all") // journal/abc..in url
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values()) ;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry){

    journalEntries.put(journalEntry.getId(),journalEntry);
        return  true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId){
    return journalEntries.get(myId);
    }

    @DeleteMapping("/delete/{id}")
    public JournalEntry deleteEntryById (@PathVariable Long id) {
//    if(journalEntries.containsKey(id)){
//        journalEntries.remove(id);
//        return true;
//    }
//        return false;

        return journalEntries.remove(id);
    }

@PutMapping("/update/id/{myId}")
    public JournalEntry updateJournal(@PathVariable Long myId, @RequestBody JournalEntry journalEntry){
       return journalEntries.put(myId,journalEntry);
    }
}
