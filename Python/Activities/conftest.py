import pytest

@pytest.fixture
def input_value():
    input = 39
    return input

@pytest.fixture
def num_list():
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list