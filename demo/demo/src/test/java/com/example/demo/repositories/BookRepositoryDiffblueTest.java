package com.example.demo.repositories;

import com.example.demo.models.Book;
import com.example.demo.models.ShadowProfile;
import com.example.demo.models.enums.Genre;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {BookRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.demo.models"})
@DataJpaTest
class BookRepositoryDiffblueTest {

    private BookRepository bookRepository;

    /**
     * Method under test: {@link BookRepository#getAllBooks()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllBooks() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessResourceUsageException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]; SQL [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.hibernate.exception.SQLGrammarException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:64)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:56)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:110)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:502)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8398)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8369)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8358)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8328)
        //       at org.h2.command.Parser.parseInsert(Parser.java:1632)
        //       at org.h2.command.Parser.parsePrepared(Parser.java:814)
        //       at org.h2.command.Parser.parse(Parser.java:689)
        //       at org.h2.command.Parser.parse(Parser.java:661)
        //       at org.h2.command.Parser.prepareCommand(Parser.java:569)
        //       at org.h2.engine.SessionLocal.prepareLocal(SessionLocal.java:631)
        //       at org.h2.engine.SessionLocal.prepareCommand(SessionLocal.java:554)
        //       at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1116)
        //       at org.h2.jdbc.JdbcPreparedStatement.<init>(JdbcPreparedStatement.java:92)
        //       at org.h2.jdbc.JdbcConnection.prepareStatement(JdbcConnection.java:1044)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$2.doPrepare(MutationStatementPreparerImpl.java:58)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:100)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   See https://diff.blue/R013 to resolve this issue.

        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book book = new Book();
        book.setAuthor(author);
        book.setCover_url("https://example.org/example");
        book.setFollowers(new ArrayList<>());
        book.setGenre(Genre.SCI_FI);
        book.setIsbn("Isbn");
        book.setLibraries(new ArrayList<>());
        book.setReviews(new ArrayList<>());
        book.setTitle("Dr");
        book.setTransactions(new ArrayList<>());

        ShadowProfile author2 = new ShadowProfile();
        author2.setFirst_name("John");
        author2.setFollowers(new ArrayList<>());
        author2.setId(2L);
        author2.setLast_name("Smith");
        author2.setProfile_pic_url("Profile pic url");
        author2.setPseudonym("42");

        Book book2 = new Book();
        book2.setAuthor(author2);
        book2.setCover_url("Cover url");
        book2.setFollowers(new ArrayList<>());
        book2.setGenre(Genre.ACTION_ADVENTURE);
        book2.setIsbn("42");
        book2.setLibraries(new ArrayList<>());
        book2.setReviews(new ArrayList<>());
        book2.setTitle("Mr");
        book2.setTransactions(new ArrayList<>());
        bookRepository.save(book);
        bookRepository.save(book2);
        bookRepository.getAllBooks();
    }

    /**
     * Method under test: {@link BookRepository#getBookById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBookById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessResourceUsageException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]; SQL [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.hibernate.exception.SQLGrammarException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:64)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:56)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:110)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:502)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8398)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8369)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8358)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8328)
        //       at org.h2.command.Parser.parseInsert(Parser.java:1632)
        //       at org.h2.command.Parser.parsePrepared(Parser.java:814)
        //       at org.h2.command.Parser.parse(Parser.java:689)
        //       at org.h2.command.Parser.parse(Parser.java:661)
        //       at org.h2.command.Parser.prepareCommand(Parser.java:569)
        //       at org.h2.engine.SessionLocal.prepareLocal(SessionLocal.java:631)
        //       at org.h2.engine.SessionLocal.prepareCommand(SessionLocal.java:554)
        //       at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1116)
        //       at org.h2.jdbc.JdbcPreparedStatement.<init>(JdbcPreparedStatement.java:92)
        //       at org.h2.jdbc.JdbcConnection.prepareStatement(JdbcConnection.java:1044)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$2.doPrepare(MutationStatementPreparerImpl.java:58)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:100)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   See https://diff.blue/R013 to resolve this issue.

        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book book = new Book();
        book.setAuthor(author);
        book.setCover_url("https://example.org/example");
        book.setFollowers(new ArrayList<>());
        book.setGenre(Genre.SCI_FI);
        book.setIsbn("Isbn");
        book.setLibraries(new ArrayList<>());
        book.setReviews(new ArrayList<>());
        book.setTitle("Dr");
        book.setTransactions(new ArrayList<>());

        ShadowProfile author2 = new ShadowProfile();
        author2.setFirst_name("John");
        author2.setFollowers(new ArrayList<>());
        author2.setId(2L);
        author2.setLast_name("Smith");
        author2.setProfile_pic_url("Profile pic url");
        author2.setPseudonym("42");

        Book book2 = new Book();
        book2.setAuthor(author2);
        book2.setCover_url("Cover url");
        book2.setFollowers(new ArrayList<>());
        book2.setGenre(Genre.ACTION_ADVENTURE);
        book2.setIsbn("42");
        book2.setLibraries(new ArrayList<>());
        book2.setReviews(new ArrayList<>());
        book2.setTitle("Mr");
        book2.setTransactions(new ArrayList<>());
        bookRepository.save(book);
        bookRepository.save(book2);

        ShadowProfile author3 = new ShadowProfile();
        author3.setFirst_name("Jane");
        author3.setFollowers(new ArrayList<>());
        author3.setId(1L);
        author3.setLast_name("Doe");
        author3.setProfile_pic_url("https://example.org/example");
        author3.setPseudonym("Pseudonym");

        Book book3 = new Book();
        book3.setAuthor(author3);
        book3.setCover_url("https://example.org/example");
        book3.setFollowers(new ArrayList<>());
        book3.setGenre(Genre.SCI_FI);
        book3.setIsbn("Isbn");
        book3.setLibraries(new ArrayList<>());
        book3.setReviews(new ArrayList<>());
        book3.setTitle("Dr");
        book3.setTransactions(new ArrayList<>());
        bookRepository.getBookById(bookRepository.save(book3).getId());
    }

    /**
     * Method under test: {@link BookRepository#addBook(String, Genre, String, String, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddBook() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessResourceUsageException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]; SQL [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.hibernate.exception.SQLGrammarException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:64)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:56)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:110)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:502)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8398)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8369)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8358)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8328)
        //       at org.h2.command.Parser.parseInsert(Parser.java:1632)
        //       at org.h2.command.Parser.parsePrepared(Parser.java:814)
        //       at org.h2.command.Parser.parse(Parser.java:689)
        //       at org.h2.command.Parser.parse(Parser.java:661)
        //       at org.h2.command.Parser.prepareCommand(Parser.java:569)
        //       at org.h2.engine.SessionLocal.prepareLocal(SessionLocal.java:631)
        //       at org.h2.engine.SessionLocal.prepareCommand(SessionLocal.java:554)
        //       at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1116)
        //       at org.h2.jdbc.JdbcPreparedStatement.<init>(JdbcPreparedStatement.java:92)
        //       at org.h2.jdbc.JdbcConnection.prepareStatement(JdbcConnection.java:1044)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$2.doPrepare(MutationStatementPreparerImpl.java:58)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:100)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   See https://diff.blue/R013 to resolve this issue.

        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book book = new Book();
        book.setAuthor(author);
        book.setCover_url("https://example.org/example");
        book.setFollowers(new ArrayList<>());
        book.setGenre(Genre.SCI_FI);
        book.setIsbn("Isbn");
        book.setLibraries(new ArrayList<>());
        book.setReviews(new ArrayList<>());
        book.setTitle("Dr");
        book.setTransactions(new ArrayList<>());

        ShadowProfile author2 = new ShadowProfile();
        author2.setFirst_name("John");
        author2.setFollowers(new ArrayList<>());
        author2.setId(2L);
        author2.setLast_name("Smith");
        author2.setProfile_pic_url("Profile pic url");
        author2.setPseudonym("42");

        Book book2 = new Book();
        book2.setAuthor(author2);
        book2.setCover_url("Cover url");
        book2.setFollowers(new ArrayList<>());
        book2.setGenre(Genre.ACTION_ADVENTURE);
        book2.setIsbn("42");
        book2.setLibraries(new ArrayList<>());
        book2.setReviews(new ArrayList<>());
        book2.setTitle("Mr");
        book2.setTransactions(new ArrayList<>());
        bookRepository.save(book);
        bookRepository.save(book2);
        bookRepository.addBook("https://example.org/example", Genre.SCI_FI, "Isbn", "Dr", 1L);
    }

    /**
     * Method under test: {@link BookRepository#deleteBookById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteBookById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.InvalidDataAccessResourceUsageException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]; SQL [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.hibernate.exception.SQLGrammarException: could not prepare statement [Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]] [insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?)]
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:64)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:56)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:108)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:110)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "BOOK" not found; SQL statement:
        //   insert into book (shadowprofile_id,cover_url,genre,isbn,title) values (?,?,?,?,?) [42102-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:502)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8398)
        //       at org.h2.command.Parser.getTableOrViewNotFoundDbException(Parser.java:8369)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8358)
        //       at org.h2.command.Parser.readTableOrView(Parser.java:8328)
        //       at org.h2.command.Parser.parseInsert(Parser.java:1632)
        //       at org.h2.command.Parser.parsePrepared(Parser.java:814)
        //       at org.h2.command.Parser.parse(Parser.java:689)
        //       at org.h2.command.Parser.parse(Parser.java:661)
        //       at org.h2.command.Parser.prepareCommand(Parser.java:569)
        //       at org.h2.engine.SessionLocal.prepareLocal(SessionLocal.java:631)
        //       at org.h2.engine.SessionLocal.prepareCommand(SessionLocal.java:554)
        //       at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1116)
        //       at org.h2.jdbc.JdbcPreparedStatement.<init>(JdbcPreparedStatement.java:92)
        //       at org.h2.jdbc.JdbcConnection.prepareStatement(JdbcConnection.java:1044)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$2.doPrepare(MutationStatementPreparerImpl.java:58)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl$StatementPreparationTemplate.prepareStatement(MutationStatementPreparerImpl.java:100)
        //       at org.hibernate.engine.jdbc.internal.MutationStatementPreparerImpl.prepareStatement(MutationStatementPreparerImpl.java:60)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.prepareStatement(GetGeneratedKeysDelegate.java:86)
        //       at org.hibernate.engine.jdbc.mutation.internal.ModelMutationHelper.lambda$identityPreparation$1(ModelMutationHelper.java:132)
        //       at org.hibernate.engine.jdbc.mutation.internal.PreparedStatementDetailsStandard.resolveStatement(PreparedStatementDetailsStandard.java:87)
        //       at org.hibernate.id.insert.GetGeneratedKeysDelegate.performInsert(GetGeneratedKeysDelegate.java:103)
        //       at org.hibernate.engine.jdbc.mutation.internal.MutationExecutorPostInsertSingleTable.execute(MutationExecutorPostInsertSingleTable.java:100)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.doStaticInserts(InsertCoordinator.java:169)
        //       at org.hibernate.persister.entity.mutation.InsertCoordinator.coordinateInsert(InsertCoordinator.java:111)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:2779)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:81)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:676)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:291)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:272)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:322)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:363)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:277)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:180)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:140)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:175)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:93)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:77)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:54)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:755)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:739)
        //       at jdk.proxy4.$Proxy158.persist(null)
        //       at jdk.proxy4.$Proxy168.save(null)
        //   See https://diff.blue/R013 to resolve this issue.

        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book book = new Book();
        book.setAuthor(author);
        book.setCover_url("https://example.org/example");
        book.setFollowers(new ArrayList<>());
        book.setGenre(Genre.SCI_FI);
        book.setIsbn("Isbn");
        book.setLibraries(new ArrayList<>());
        book.setReviews(new ArrayList<>());
        book.setTitle("Dr");
        book.setTransactions(new ArrayList<>());

        ShadowProfile author2 = new ShadowProfile();
        author2.setFirst_name("John");
        author2.setFollowers(new ArrayList<>());
        author2.setId(2L);
        author2.setLast_name("Smith");
        author2.setProfile_pic_url("Profile pic url");
        author2.setPseudonym("42");

        Book book2 = new Book();
        book2.setAuthor(author2);
        book2.setCover_url("Cover url");
        book2.setFollowers(new ArrayList<>());
        book2.setGenre(Genre.ACTION_ADVENTURE);
        book2.setIsbn("42");
        book2.setLibraries(new ArrayList<>());
        book2.setReviews(new ArrayList<>());
        book2.setTitle("Mr");
        book2.setTransactions(new ArrayList<>());
        bookRepository.save(book);
        bookRepository.save(book2);

        ShadowProfile author3 = new ShadowProfile();
        author3.setFirst_name("Jane");
        author3.setFollowers(new ArrayList<>());
        author3.setId(1L);
        author3.setLast_name("Doe");
        author3.setProfile_pic_url("https://example.org/example");
        author3.setPseudonym("Pseudonym");

        Book book3 = new Book();
        book3.setAuthor(author3);
        book3.setCover_url("https://example.org/example");
        book3.setFollowers(new ArrayList<>());
        book3.setGenre(Genre.SCI_FI);
        book3.setIsbn("Isbn");
        book3.setLibraries(new ArrayList<>());
        book3.setReviews(new ArrayList<>());
        book3.setTitle("Dr");
        book3.setTransactions(new ArrayList<>());
        bookRepository.deleteBookById(bookRepository.save(book3).getId());
    }
}

