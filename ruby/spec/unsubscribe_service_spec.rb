require_relative "../app/unsubscribe_service.rb"

describe UnsubscribeService do
  subject { UnsubscribeService.new }

  let(:statement_charges) { [] }
  let(:sample_name) { "Spotify" }
  let(:sample_date) { "1/1/18" }
  let(:sample_amount) { 9.99 }

  before do
    allow(StatementAPI).to receive(:get_charges).and_return(statement_charges)
  end

  describe "#display_recurring_charges" do
    it "sums the charges that occur more than once" do
      create_charge(sample_name, "1/1/18", sample_amount)
      create_charge(sample_name, "1/2/18", sample_amount)

      charges = subject.display_recurring_charges

      expect(charges[sample_name]).to be(2)
    end

    # This test fails initially
    it "does not include charges that only occur once" do
      create_charge(sample_name, sample_date, sample_amount)

      charges = subject.display_recurring_charges

      expect(charges.has_key?(sample_name)).to be(false)
    end
  end

  def create_charge(name, date, amount)
    statement_charges.push({
      name: name,
      date: date,
      amount: amount,
    })
  end

end
