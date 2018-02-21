package masters.vlad.humeniuk.notesviper.domain.interactors.implementation;

import masters.vlad.humeniuk.notesviper.database.dao.NoteDao;
import masters.vlad.humeniuk.notesviper.domain.entity.Note;
import masters.vlad.humeniuk.notesviper.domain.interactors.AddNoteInteractor;
import masters.vlad.humeniuk.notesviper.domain.mappers.NoteDbMapper;
import io.reactivex.Observable;

public class AddNoteInteractorImpl implements AddNoteInteractor {

    private NoteDao noteDao;

    private NoteDbMapper noteDbMapper;

    public AddNoteInteractorImpl(NoteDao noteDao, NoteDbMapper noteDbMapper) {
        this.noteDao = noteDao;
        this.noteDbMapper = noteDbMapper;
    }

    @Override
    public Observable<Note> addNote(Note note) {
        return Observable.fromCallable(() ->
                noteDao.insert(noteDbMapper.mapBack(note)))
                .map(id -> {
                    note.setId(id);
                    return note;
                });
    }
}
