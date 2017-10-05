package Model;

import java.util.ArrayList;

public class Notebook implements iNotebook {

    // Global attributes
    private ArrayList<String> notes;
    private int count; // Need to keep track of Arraylist

    public Notebook() {
        notes = new ArrayList<>();
    }

    // Getters and Setters
    // @return returns the all notes
    public ArrayList<String> getNotes() {
        return notes;
    }

    // @param takes arraysList of strings and assigns it to notes
    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }


    // Methods

    @Override
    public void add(String note) {

        if (!isEmpty()) {
            //
            for (int i = count; i >= 1; i--) {
                notes.add(i, notes.get(i - 1));
            }

            notes.add(0, note);
            notes.remove(count + 1); // Need to remove last duplicate
            count++;
        } else {
            notes.add(note);
            count++;
        }

    }


    @Override
    public void remove(int noteIndex) {
        notes.remove(noteIndex);
        count--;
    }

    @Override
    public int getSize() {
        return this.notes.size();
    }

    @Override
    public boolean isEmpty() {
        return notes.size() == 0;
    }

}