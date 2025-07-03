package org.example;

import org.example.ui.pages.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UiScenarioTest extends BaseUiTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PublishersListPage publishersListPage;

    @Autowired
    private PostsListPage postsListPage;

    @Autowired
    private CreatePostPage createPostPage;

    @Autowired
    private CreatePublisherPage createPublisherPage;

    @Autowired
    private EditPostPage editPostPage;

    @Autowired
    private PostPage postPage;

    private static final String WELCOME_MESSAGE = "Welcome, Candidate!";
    private static final String PUBLISHER_NAME = "Automata_" + java.util.UUID.randomUUID();
    private static final String PUBLISHER_EMAIL = "automata_" + java.util.UUID.randomUUID() + "@gmail.com";
    private static final String POST_TITLE = java.util.UUID.randomUUID().toString();
    private static final String POST_CONTENT = java.util.UUID.randomUUID().toString();
    private static final String POST_STATUS = "REMOVED";

    @Test
    public void uiScenarioTest() {

        //initial login
        loginPage.open();
        loginPage.loginButton().should().beVisible().click();
        mainPage.welcomeMessage().should().beVisible();
        assertThat(mainPage.welcomeMessage().getText()).isEqualTo(WELCOME_MESSAGE);

        //Redirect to publisher
        mainPage.happyFolderButton().should().beVisible().click();
        mainPage.publisherButton().should().beVisible().click();
        publishersListPage.publisherPageTitle().should().beVisible();
        publishersListPage.createPublisherButton().should().beVisible().click();

        //Create publisher
        createPublisherPage.createPublisherPageTitle().should().beVisible();
        createPublisherPage.publisherNameTextInput().should().beVisible().sendText(PUBLISHER_NAME);
        createPublisherPage.publisherEmailTextInput().should().beVisible().sendText(PUBLISHER_EMAIL);
        createPublisherPage.savePublisherButton().should().beVisible().click();
        publishersListPage.publisherPageTitle().should().beVisible();

        //Create new post and link to publisher
        mainPage.postItem().should().beVisible().click();
        postsListPage.postPageTitle().should().beVisible();
        postsListPage.createPostButton().should().beVisible().click();
        createPostPage.createPublisherPageTitle().should().beVisible();
        createPostPage.postTitleTextInput().should().beVisible().sendText(POST_TITLE);
        createPostPage.postContentTextInput().should().beVisible().sendText(POST_CONTENT);
        createPostPage.postStatusDropDown().should().beVisible().click();
        createPostPage.postStatusActiveButton().should().beVisible().click();
        createPostPage.postPublishedCheckBox().should().beVisible().click();
        createPostPage.linkToPublisherDropDown().should().beVisible().click();
        createPostPage.publisherButtonByText(PUBLISHER_EMAIL).should().beVisible().click();
        createPostPage.savePostButton().should().beVisible().click();

        //Edit post
        postsListPage.postFromListByTitleButton(POST_TITLE).should().beVisible().click();
        postPage.postPageTitle().should().beVisible();
        postPage.editPostButton().should().beVisible().click();
        editPostPage.editPostPageTitle().should().beVisible();
        editPostPage.postStatusDropDown().should().beVisible().click();
        editPostPage.postStatusRemovedButton().should().beVisible().click();
        editPostPage.savePostButton().should().beVisible().click();
        postPage.postPageTitle().should().beVisible();

        //Validate status of post record after editing
        assertThat(postPage.postTitle().getText()).isEqualTo(POST_TITLE);
        assertThat(postPage.postStatus().getText()).isEqualTo(POST_STATUS);
    }
} 