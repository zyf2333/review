package com.example.design.command;

/**
 * @Author zyf
 * @Description 命令模式
 * @ClassName CommandPattern
 * @Date 2020/8/6 16:22
 **/
public class CommandPattern {

}

//调用者
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

//抽象命令
interface Command {
    public abstract void execute();
}

//具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    public void execute() {
        receiver.action();
    }
}

//接收者，业务的真正实现者。
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}
