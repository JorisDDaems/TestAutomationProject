package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.VanillaJsPage;
import pages.HoverPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VanillaJsTests extends BaseTests {

    @Test
    public void test1CreateAToDo(){
        VanillaJsPage vanillaJsPage = homePage.clickVanillaJs();
        vanillaJsPage.enterText("Automation is fun!");
        assertEquals(vanillaJsPage.getResult(), "Automation is fun!");
        System.out.println(vanillaJsPage.getToDoListAmount());
    }

    @Test
    public void test2RemoveAToDo(){
        String text1 = "The first to do!";
        String text2 = "The second to do!";
        String text3 = "The third to do!";
        VanillaJsPage vanillaJsPage = homePage.clickVanillaJs();
        vanillaJsPage.enterText(text1);
        vanillaJsPage.enterText(text2);
        vanillaJsPage.enterText(text3);
        vanillaJsPage.deleteToDo(1);
        assertEquals(vanillaJsPage.getToDoListAmount(), 1);
        assertEquals(vanillaJsPage.getResult(), text1 + "\n" + text3);
        System.out.println(vanillaJsPage.getResult());
    }

    @Test
    public void test3CompleteAToDo(){
        String text1 = "The first to do!";
        String text2 = "The second to do!";
        String text3 = "The third to do!";
        VanillaJsPage vanillaJsPage = homePage.clickVanillaJs();
        vanillaJsPage.enterText(text1);
        vanillaJsPage.enterText(text2);
        vanillaJsPage.enterText(text3);
        vanillaJsPage.selectCompleteCheckBox(3);
        System.out.println(vanillaJsPage.checkIfCheckBoxIsSelected());
        assertEquals(vanillaJsPage.checkIfCheckBoxIsSelected(), "The third to do!");
        System.out.println(vanillaJsPage.amountOfCheckBoxesSelected());
        assertEquals(vanillaJsPage.amountOfCheckBoxesSelected(), 1);
    }

    @Test
    public void test4EditAToDo(){
        String text1 = "The first to do!";
        String text2 = "The second to do!";
        String text3 = "The third to do!";
        VanillaJsPage vanillaJsPage = homePage.clickVanillaJs();
        vanillaJsPage.enterText(text1);
        vanillaJsPage.enterText(text2);
        vanillaJsPage.enterText(text3);

        System.out.println(vanillaJsPage.getResult());

        System.out.println(vanillaJsPage.find("The second to do!"));

        vanillaJsPage.modifyText("this is the new input");

        assertEquals(vanillaJsPage.getResult(), text1 + "\nthis is the new input\n"  + text3);
    }

    @Test
    public void test5ViewingCompletedToDo(){
        String text1 = "The first to do!";
        String text2 = "The second to do!";
        String text3 = "The third to do!";
        VanillaJsPage vanillaJsPage = homePage.clickVanillaJs();
        vanillaJsPage.enterText(text1);
        vanillaJsPage.enterText(text2);
        vanillaJsPage.enterText(text3);
        vanillaJsPage.changeToCompletedPage();
        System.out.println(vanillaJsPage.toDoListAmount());
        assertEquals(vanillaJsPage.toDoListAmount(), 0);
        assertEquals(vanillaJsPage.amount(), "3");
        vanillaJsPage.changeToAllPage();

        vanillaJsPage.selectCompleteCheckBox(1);
        vanillaJsPage.selectCompleteCheckBox(2);

        vanillaJsPage.changeToCompletedPage();
        assertEquals(vanillaJsPage.amountOfCheckBoxesSelected(), 2);
        assertEquals(vanillaJsPage.amount(), "1");

    }




    @Test
    public void testHoverDeleteElement(){
        String text1 = "The first to do!";
        String text2 = "The second to do!";
        String text3 = "The third to do!";
        VanillaJsPage vanillaJsPage = homePage.clickVanillaJs();
        vanillaJsPage.enterText(text1);
        vanillaJsPage.enterText(text2);
        vanillaJsPage.enterText(text3);





        HoverPage.FigureCaption caption = HoverPage.hoverOverList(1);
        //assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        //System.out.println(caption);
        System.out.println(caption.getTitle());
        //caption.deleteToDo();
        System.out.println(caption.getLink());
        //System.out.println(caption.getLinkText());
        caption.getLinkText();
        assertEquals(caption.getTitle(), "The first to do!");
        //assertEquals(caption.getLinkText(), "The first to do!");
    }


}
