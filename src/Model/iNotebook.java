package Model;

/* 05/10/2017
 * Bereketab Gulai
 * ProjectNotebook
 * Model
 */

public interface iNotebook {

    /**
     * @param note is added notes
     */
         public void add(String note);

    // @param takes note and removes it from the notes
    public void remove(int noteIndex);

    // @return returns the size of the notes
    public int getSize();

    // @return returns whether the notes is empty or not
    public boolean isEmpty();
}
