package masters.vlad.humeniuk.notesviper.domain.interactors;

import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import io.reactivex.Observable;

public interface AddNoteInteractor {

    Observable<Note> addNote(Note note);
}
