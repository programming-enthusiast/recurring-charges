require "yaml"
require_relative "../lib/statement_api.rb"

class UnsubscribeService
  def display_recurring_charges
    recurring_charges = Hash.new(0)

    StatementAPI.get_charges.each do |charge|
      name = charge[:name]
      recurring_charges[name] += 1
    end

    recurring_charges.delete_if do |name, charge_count|
      charge_count >= 1
    end

    recurring_charges
  end
end
