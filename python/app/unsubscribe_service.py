from app.statement_api import StatementAPI

class UnsubscribeService:
    def display_recurring_charges():
        recurring_charges = {}
        bill_statement = {}

        for charge in StatementAPI.get_charges():
            name = charge["name"]
            total = bill_statement.get(name, 0)
            total += 1
            bill_statement[name] = total

        for charge_name, charge_count in bill_statement.items():
            if charge_count >= 1:
                recurring_charges[charge_name] = charge_count

        return recurring_charges
