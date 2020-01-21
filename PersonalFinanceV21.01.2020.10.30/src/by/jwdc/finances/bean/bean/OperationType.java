package by.jwdc.finances.bean.bean;

public class OperationType {

    private String name;
    private boolean incomeOperation;

    public OperationType() {
    }

    public OperationType(String name, boolean incomeOperation) {
        this.name = name;
        this.incomeOperation = incomeOperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIncomeOperation() {
        return incomeOperation;
    }

    public void setIncomeOperation(boolean incomeOperation) {
        this.incomeOperation = incomeOperation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        OperationType operationType = (OperationType)obj;
        return (this.name.equals(operationType.name));
    }

    @Override
    public int hashCode() {
        int res = 7;
        int prime = 31;

        res = res * prime + ((this.name == null) ? 0 : name.hashCode());

        return res;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "name='" + name +
                ", isInComeOperation=" + incomeOperation +
                '}';
    }
}
