package masters.vlad.humeniuk.notesviper.presentation.editnote.view;

import masters.vlad.humeniuk.notesviper.domain.entity.Note;

public interface EditNoteView {

    void showNote(Note note);

    void showEmptyFieldsError();
}
