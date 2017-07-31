package bank.service;

/**
 * Created by Dewei Xiang on 7/30/2017.
 */
public interface IAccountOperation {

    void execute();
    void undo();
}
