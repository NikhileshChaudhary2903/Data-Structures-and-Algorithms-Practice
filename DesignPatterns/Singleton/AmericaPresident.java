public class AmericaPresident {
private static AmericaPresident thePresident;
private AmericaPresident() {}
public static AmericaPresident getPresident() {
if (thePresident == null) {
thePresident = new AmericaPresident();
}
return thePresident;
}
}
