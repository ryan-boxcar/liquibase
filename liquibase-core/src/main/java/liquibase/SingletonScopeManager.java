package liquibase;

public class SingletonScopeManager extends ScopeManager {

    private ThreadLocal<Scope> currentScope = new ThreadLocal<Scope>();

    @Override
    public synchronized Scope getCurrentScope() {
        return currentScope.get();
    }

    @Override
    protected Scope init(Scope scope) throws Exception {
        return scope;
    }

    @Override
    protected synchronized void setCurrentScope(Scope scope) {
        this.currentScope.set(scope);
    }
}
