class StatementAPI
  def self.get_charges
    YAML.load_file(File.join(Dir.pwd, "config/charges.yml"))[:charges]
  end
end
