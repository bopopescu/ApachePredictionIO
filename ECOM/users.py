import predictionio
import argparse

parser = argparse.ArgumentParser(description='Process some integers.')
parser.add_argument('string', metavar='N', type=str,
                   help='an integer for the accumulator')
args = parser.parse_args()
print(args.string)

client = predictionio.EventClient(
  access_key="Ym4y6Utt1XE91ZABcVQBsBaZJgZoqX6a5p7JF9-3N6r_yKgvpbc_NQN4_BnXZgZH",
  url="https://localhost:7070",
  threads=5,
  qsize=500
)

# Create a new user

client.create_event(
  event="$set",
  entity_type="user",
  entity_id="u0"
)


