package com.isa.domain;

import com.isa.services.SalaryCalculator;

public enum ContractState implements SalaryCalculator {

    B2B{
        @Override
        public void calculateSalary(Contract contract) {
            double base = contract.getEmployee().getSalaryBase();
            contract.setSalary(base*base);
            contract.setExpiryTime(ExpiryTime.None);
        }
    },
    UoP{
        @Override
        public void calculateSalary(Contract contract) {
            double base = contract.getEmployee().getSalaryBase();
            contract.setSalary(base);
            contract.setExpiryTime(ExpiryTime.ThreeMonth);

        }
    },
    UD{
        @Override
        public void calculateSalary(Contract contract) {
            double base = contract.getEmployee().getSalaryBase();
            contract.setSalary(base * base / 2);
            contract.setExpiryTime(ExpiryTime.OneMonth);
        }
    }


}
