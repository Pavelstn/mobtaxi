/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import net.sourceforge.jxa.*;

/**
 * @author pavel
 */
public class HelloMIDlet extends MIDlet implements CommandListener, XmppListener {

    private boolean midletPaused = false;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command screenCommand;
    private Command config;
    private Command backCommand;
    private Command okCommand;
    private Command connect;
    private Command backCommand1;
    private Command tocontactList;
    private Command tomessage;
    private Command backCommand2;
    private Command screenCommand1;
    private Form form;
    private Form loginForm;
    private List contactList;
    private List messages;
    private TextBox send_box;
    //</editor-fold>//GEN-END:|fields|0|
    // private List contacts_list;
    private TextField id_field;
    private TextField passwd_field;
    private TextField server_field;
    private Jxa jxa;
    private Roster roster = new Roster();
    private Alert msg_alert;
    private String whom;

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == contactList) {//GEN-BEGIN:|7-commandAction|1|42-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|42-preAction
                // write pre-action user code here
                String to = contactList.getString(contactList.getSelectedIndex());
                whom = to;
                send_box.setTitle("to " + to);
                Display.getDisplay(this).setCurrent(send_box);
                contactListAction();//GEN-LINE:|7-commandAction|2|42-postAction
                // write post-action user code here
            } else if (command == backCommand1) {//GEN-LINE:|7-commandAction|3|48-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|4|48-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|25-preAction
        } else if (displayable == form) {
            if (command == config) {//GEN-END:|7-commandAction|5|25-preAction
                // write pre-action user code here
                switchDisplayable(null, getLoginForm());//GEN-LINE:|7-commandAction|6|25-postAction
                // write post-action user code here
            } else if (command == connect) {//GEN-LINE:|7-commandAction|7|39-preAction
                // write pre-action user code here
                //this.ja_login();//соединяемся с сервером
          
//GEN-LINE:|7-commandAction|8|39-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|9|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|10|19-postAction
                // write post-action user code here
            } else if (command == tocontactList) {//GEN-LINE:|7-commandAction|11|45-preAction
                // write pre-action user code here
                Display.getDisplay(this).setCurrent(contactList);
                switchDisplayable(null, getContactList());//GEN-LINE:|7-commandAction|12|45-postAction
                // write post-action user code here
            } else if (command == tomessage) {//GEN-LINE:|7-commandAction|13|55-preAction
                // write pre-action user code here
                switchDisplayable(null, getMessages());//GEN-LINE:|7-commandAction|14|55-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|35-preAction
        } else if (displayable == loginForm) {
            if (command == backCommand) {//GEN-END:|7-commandAction|15|35-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|16|35-postAction
                // write post-action user code here
            } else if (command == connect) {//GEN-LINE:|7-commandAction|17|63-preAction
                // write pre-action user code here
              //  this.ja_login();//соединяемся с сервером
                      String id = id_field.getString();
                String passwd = passwd_field.getString();
                String server = server_field.getString();
                java.lang.System.out.println("*debug* " + id);
                java.lang.System.out.println("*debug* " + passwd);
                java.lang.System.out.println("*debug* " + server);
                Display.getDisplay(this).setCurrent(contactList);
                jxa = new Jxa(id, passwd, "mobile", 10, server, "5223", true);
                jxa.addListener(this);
                jxa.start();

//GEN-LINE:|7-commandAction|18|63-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|19|33-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|20|33-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|52-preAction
        } else if (displayable == messages) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|21|52-preAction
                // write pre-action user code here
                messagesAction();//GEN-LINE:|7-commandAction|22|52-postAction
                // write post-action user code here
            } else if (command == backCommand2) {//GEN-LINE:|7-commandAction|23|58-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|24|58-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|7-postCommandAction
        }//GEN-END:|7-commandAction|25|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|26|
    //</editor-fold>//GEN-END:|7-commandAction|26|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("Welcome", new Item[] { });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getConfig());
            form.addCommand(getConnect());
            form.addCommand(getTocontactList());
            form.addCommand(getTomessage());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: screenCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of screenCommand component.
     * @return the initialized component instance
     */
    public Command getScreenCommand() {
        if (screenCommand == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            screenCommand = new Command("\u042D\u043A\u0440\u0430\u043D", Command.SCREEN, 0);//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return screenCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: config ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of config component.
     * @return the initialized component instance
     */
    public Command getConfig() {
        if (config == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            config = new Command("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430", Command.ITEM, 0);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return config;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: loginForm ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of loginForm component.
     * @return the initialized component instance
     */
    public Form getLoginForm() {
        if (loginForm == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            id_field = new TextField("ID(xxx@xxx.xxx)", "pavelstn@gmail.com", 30, TextField.ANY);
            passwd_field = new TextField("password", "***********", 30, TextField.PASSWORD);
            server_field = new TextField("server", "talk.google.com", 30, TextField.ANY);
            loginForm = new Form("loginform");//GEN-BEGIN:|30-getter|1|30-postInit
            loginForm.addCommand(getOkCommand());
            loginForm.addCommand(getBackCommand());
            loginForm.addCommand(getConnect());
            loginForm.setCommandListener(this);//GEN-END:|30-getter|1|30-postInit
            // write post-init user code here
            loginForm.append(id_field);
            loginForm.append(passwd_field);
            loginForm.append(server_field);
            // loginForm = new Command("Exit", Command.EXIT, 0);
            // loginForm = new Command("Login", Command.OK, 1);
        }//GEN-BEGIN:|30-getter|2|
        return loginForm;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            okCommand = new Command("OK", Command.OK, 0);//GEN-LINE:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            backCommand = new Command("\u041D\u0430\u0437\u0430\u0434", Command.BACK, 0);//GEN-LINE:|34-getter|1|34-postInit
            // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|34-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: connect ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of connect component.
     * @return the initialized component instance
     */
    public Command getConnect() {
        if (connect == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            connect = new Command("\u0421\u043E\u0435\u0434\u0438\u043D\u0438\u0442\u044C\u0441\u044F", Command.ITEM, 0);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return connect;
    }
    //</editor-fold>//GEN-END:|38-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tocontactList ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of tocontactList component.
     * @return the initialized component instance
     */
    public Command getTocontactList() {
        if (tocontactList == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            tocontactList = new Command("\u042D\u043B\u0435\u043C\u0435\u043D\u0442", Command.ITEM, 0);//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return tocontactList;
    }
    //</editor-fold>//GEN-END:|44-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: contactList ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of contactList component.
     * @return the initialized component instance
     */
    public List getContactList() {
        if (contactList == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            contactList = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|40-getter|1|40-postInit
            contactList.addCommand(getBackCommand1());
            contactList.setCommandListener(this);//GEN-END:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return contactList;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: contactListAction ">//GEN-BEGIN:|40-action|0|40-preAction
    /**
     * Performs an action assigned to the selected list element in the contactList component.
     */
    public void contactListAction() {//GEN-END:|40-action|0|40-preAction
        // enter pre-action user code here
        String __selectedString = getContactList().getString(getContactList().getSelectedIndex());//GEN-LINE:|40-action|1|40-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|40-action|2|
    //</editor-fold>//GEN-END:|40-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            backCommand1 = new Command("\u041D\u0430\u0437\u0430\u0434", Command.BACK, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tomessage ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of tomessage component.
     * @return the initialized component instance
     */
    public Command getTomessage() {
        if (tomessage == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            tomessage = new Command("\u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", Command.ITEM, 0);//GEN-LINE:|54-getter|1|54-postInit
            // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return tomessage;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: messages ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initiliazed instance of messages component.
     * @return the initialized component instance
     */
    public List getMessages() {
        if (messages == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            messages = new List("list", Choice.IMPLICIT);//GEN-BEGIN:|51-getter|1|51-postInit
            messages.addCommand(getBackCommand2());
            messages.setCommandListener(this);//GEN-END:|51-getter|1|51-postInit
            // write post-init user code here
        }//GEN-BEGIN:|51-getter|2|
        return messages;
    }
    //</editor-fold>//GEN-END:|51-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: messagesAction ">//GEN-BEGIN:|51-action|0|51-preAction
    /**
     * Performs an action assigned to the selected list element in the messages component.
     */
    public void messagesAction() {//GEN-END:|51-action|0|51-preAction
        // enter pre-action user code here
        String __selectedString = getMessages().getString(getMessages().getSelectedIndex());//GEN-LINE:|51-action|1|51-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|51-action|2|
    //</editor-fold>//GEN-END:|51-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of backCommand2 component.
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            backCommand2 = new Command("\u041D\u0430\u0437\u0430\u0434", Command.BACK, 0);//GEN-LINE:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return backCommand2;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: send_box ">//GEN-BEGIN:|60-getter|0|60-preInit
    /**
     * Returns an initiliazed instance of send_box component.
     * @return the initialized component instance
     */
    public TextBox getSend_box() {
        if (send_box == null) {//GEN-END:|60-getter|0|60-preInit
            // write pre-init user code here
            send_box = new TextBox("textBox", null, 100, TextField.ANY);//GEN-LINE:|60-getter|1|60-postInit
            // write post-init user code here
        }//GEN-BEGIN:|60-getter|2|
        return send_box;
    }
    //</editor-fold>//GEN-END:|60-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: screenCommand1 ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of screenCommand1 component.
     * @return the initialized component instance
     */
    public Command getScreenCommand1() {
        if (screenCommand1 == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            screenCommand1 = new Command("\u042D\u043A\u0440\u0430\u043D", Command.ITEM, 0);//GEN-LINE:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return screenCommand1;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void onConnFailed(String msg) {
        throw new UnsupportedOperationException("onConnFailed");
    }

    public void onAuth(String resource) {
        try {
            jxa.getRoster();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        contactList.setTitle("contacts");
    }

    public void onAuthFailed(String message) {
        throw new UnsupportedOperationException("onAuthFailed");
    }

    public void onMessageEvent(String from, String body) {
        //msg_alert = new Alert("from " + from, body, null, AlertType.INFO);
        //  alert.setTimeout(Alert.FOREVER);
        // Display.getDisplay(this).setCurrent(alert);
        messages.append(from + ":" + body, null);
        Display.getDisplay(this).setCurrent(messages);

        java.lang.System.out.println("*debug* message, " + from + ":" + body);
        java.lang.System.out.println("*debugddd* " + this.roster.get_allMessages());
    }

    public void onContactEvent(String jid, String name, String group, String subscription) {
        if (subscription.equals("both")) {
            contactList.append(jid, null);
        }
    }

    public void onContactOverEvent() {
    }

    public void onStatusEvent(String jid, String show, String status) {
        java.lang.System.out.println("*debug* onStatusEvent: " + jid + ", " + show + ", " + status);
        int i = jid.indexOf('/');
        String name = jid.substring(0, i);
        for (i = 0; i < contactList.size(); i++) {
            if (name.equals(contactList.getString(i))) {
                if (show.equals("na")) {
                    contactList.set(i, name, null);
                } else {
                    contactList.set(i, name, null);
                }
            }
        }
    }

    public void onSubscribeEvent(String jid) {
    }

    public void onUnsubscribeEvent(String jid) {
    }
//    private void ja_login() {
//        String id = id_field.getString();
//        String passwd = passwd_field.getString();
//        String server = server_field.getString();
//        java.lang.System.out.println("*debug* " + id);
//        java.lang.System.out.println("*debug* " + passwd);
//        java.lang.System.out.println("*debug* " + server);
//        Display.getDisplay(this).setCurrent(contactList);
//        jxa = new Jxa(id, passwd, "mobile", 10, server, "5223", true);
//        jxa.addListener(this);
//        jxa.start();
//    }
}
