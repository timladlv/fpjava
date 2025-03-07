package org.example.chap4design;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/*
A code loan pattern is a design pattern that ensures a resource is disposed of when it is no longer in use.
This pattern is useful for resources like database connections, files, sockets, and memory.

How does a loan pattern work?
- A resource is created
- The resource is loaned to a function
- The function uses the resource
- The resource is destroyed

Benefits of a loan pattern
- The loan pattern allows any function to use the loaned resource
- The loan pattern takes care of the creation and destruction of the resource
 */
public class LoanPattern {
    private final Map<String, String> captured = new HashMap<>();
    private LoanPattern() {
        // singleton
    }
    public static Map<String, String> send(final Consumer<LoanPattern> block) {
        final LoanPattern loanPattern = new LoanPattern(); // instantiated
        block.accept(loanPattern); // loaned to the function
        return loanPattern.captured; // instance private, does not escape
    }

    public LoanPattern from(final String from) {
        this.captured.put("from", from);
        return this;
    }

    public LoanPattern to(final String to) {
        this.captured.put("to", to);
        return this;
    }

    public LoanPattern subject(final String subject) {
        this.captured.put("subject", subject);
        return this;
    }

    public LoanPattern body(final String body) {
        this.captured.put("body", body);
        return this;
    }
}
