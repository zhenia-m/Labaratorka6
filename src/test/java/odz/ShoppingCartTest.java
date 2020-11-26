package odz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addItem(new ItemNew("Apple", 0.99, 5));
        cart.addItem(new ItemSecondFree("Banana", 20.00, 4));
        cart.addItem(new ItemSale("A long piece of toilet paper", 17.20, 1));
        cart.addItem(new ItemRegular("Nails", 2.00, 500));
    }

    @Test
    void formatTicket() {
        //System.out.println(cart.formatTicket());
        assertEquals("# Item                          Price Quan. Discount   Total \n"+
                        "------------------------------------------------------------\n" +
                        "1 Apple                          $.99     5        -   $4.95 \n" +
                        "2 Banana                       $20.00     4      50%  $40.00 \n"+
                        "3 A long piece of toilet paper $17.20     1      70%   $5.16 \n"+
                        "4 Nails                         $2.00   500      50% $500.00 \n"+
                        "------------------------------------------------------------\n"+
                        "4                                                    $550.11 ",
                cart.formatTicket());
    }

    @Test
    public void testAppendFormatted() {
        StringBuilder sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 14);
        assertEquals(sb.toString(), "   SomeLine    ");
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 15);
        assertEquals(sb.toString(), "   SomeLine     ");
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 5);
        assertEquals(sb.toString(), "SomeL ");
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 1, 15);
        assertEquals(sb.toString(), "       SomeLine ");
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", -1, 15);
        assertEquals(sb.toString(), "SomeLine        ");
    }

    @Test
    public void testCalculateDiscount() {
        assertEquals(80, new ItemSale("Test",0.00,500).calculateDiscount());
        assertEquals(73, new ItemSale("Test",0.00,30).calculateDiscount());
        assertEquals(71, new ItemSale("Test",0.00,10).calculateDiscount());
        assertEquals(70, new ItemSale("Test",0.00,9).calculateDiscount());
        assertEquals(70, new ItemSale("Test",0.00,1).calculateDiscount());
        assertEquals(0,  new ItemNew("Test",0.00,20).calculateDiscount());
        assertEquals(0,  new ItemNew("Test",0.00,10).calculateDiscount());
        assertEquals(0,  new ItemNew("Test",0.00,1).calculateDiscount());
        assertEquals(80, new ItemSecondFree("Test",0.00,500).calculateDiscount());
        assertEquals(53, new ItemSecondFree("Test",0.00,30).calculateDiscount());
        assertEquals(51, new ItemSecondFree("Test",0.00,10).calculateDiscount());
        assertEquals(50, new ItemSecondFree("Test",0.00,9).calculateDiscount());
        assertEquals(50, new ItemSecondFree("Test",0.00,2).calculateDiscount());
        assertEquals(0,  new ItemSecondFree("Test",0.00,1).calculateDiscount());;
    }
}