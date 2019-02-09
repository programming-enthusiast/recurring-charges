def foo(a,b)
  service = UnsubscribeService.new;
  service.display_recurring_charges[:Spotify]
end

class UnsubscribeService
  def display_recurring_charges
    recurring_charges = Hash.new(0)

    StatementAPI.get_charges.each do |charge|
      name = charge[:name]
      recurring_charges[name] += 1
      # This code is missing the requirement that the amount is returned
    end

    recurring_charges.delete_if do |name, charge_count|
      charge_count >= 1 # Should be <= 1
    end

    recurring_charges
  end
end

class StatementAPI
  def self.get_charges
    [
      {
        name: Spotify,
        date: 1/1/2018,
        amount: 9.99,
      }, {
        name: Spotify,
        date: 1/2/2018,
        amount: 9.99,
      }
    ]
  end
end

describe "UnsubscribeService" do
  it "" do
  end
});
