package masters.vlad.humeniuk.notesviper.di.modules;

import dagger.Module;
import dagger.Provides;
import masters.vlad.humeniuk.notesviper.di.scopes.UserScope;
import masters.vlad.humeniuk.notesviper.presentation.base.BaseActivity;
import masters.vlad.humeniuk.notesviper.presentation.categories.router.CategoriesListRouter;
import masters.vlad.humeniuk.notesviper.presentation.categories.router.CategoriesListRouterImpl;
import masters.vlad.humeniuk.notesviper.presentation.createnote.router.CreateNoteRouter;
import masters.vlad.humeniuk.notesviper.presentation.createnote.router.CreateNoteRouterImpl;
import masters.vlad.humeniuk.notesviper.presentation.editnote.router.EditNoteRouter;
import masters.vlad.humeniuk.notesviper.presentation.editnote.router.EditNoteRouterImpl;
import masters.vlad.humeniuk.notesviper.presentation.main.router.MainRouter;
import masters.vlad.humeniuk.notesviper.presentation.main.router.MainRouterImpl;
import masters.vlad.humeniuk.notesviper.presentation.noteslist.router.NotesListRouter;
import masters.vlad.humeniuk.notesviper.presentation.noteslist.router.NotesListRouterImpl;

@Module
public class RouterModule {

    @Provides
    @UserScope
    MainRouter provideMainRouter(BaseActivity baseActivity) {
        return new MainRouterImpl(baseActivity);
    }

    @Provides
    @UserScope
    NotesListRouter provideNotesListRouter(BaseActivity baseActivity) {
        return new NotesListRouterImpl(baseActivity);
    }

    @Provides
    @UserScope
    CreateNoteRouter provideCreateNoteRouter(BaseActivity baseActivity) {
        return new CreateNoteRouterImpl(baseActivity);
    }

    @Provides
    @UserScope
    EditNoteRouter provideEditNoteRouter(BaseActivity baseActivity) {
        return new EditNoteRouterImpl(baseActivity);
    }

    @Provides
    @UserScope
    CategoriesListRouter provideCategoriesListRouter(BaseActivity baseActivity) {
        return new CategoriesListRouterImpl(baseActivity);
    }
}
