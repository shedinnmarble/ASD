package bank.service;

import java.util.Stack;

/**
 * Created by Dewei Xiang on 7/30/2017.
 */
public class AccountManager {
    private Stack<IAccountOperation> commandStack = new Stack<>();

    public void ExecuteCommand(IAccountOperation cmd)
    {
        cmd.execute();

            commandStack.push(cmd);

    }


    public void Undo()
    {
       if(commandStack.size() > 0){
           IAccountOperation undo = commandStack.pop();
           undo.undo();
       }
    }

}
