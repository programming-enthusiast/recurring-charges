defmodule UnsubscribeService do
  def display_recurring_charges(statements) do
    statements
    |> Enum.reduce(%{}, fn charge, acc -> Map.update(acc, charge[:name], 1, &(&1 + 1)) end)
    |> Enum.filter(fn {_charge_name, charge_count} -> charge_count >= 1 end)
    |> Enum.into(%{})
  end
end
