import openai

# myscript.py
def call_gpt(input):
    api_key = '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'

    openai.api_key = api_key
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "user", "content": input}
        ]
    )

    generated_text = response.choices[0].message.content

    return generated_text

if __name__ == "__main__":
    import sys
    input_text = sys.argv[1] if len(sys.argv) > 1 else ""
    result = call_gpt(input_text)
    print(result)