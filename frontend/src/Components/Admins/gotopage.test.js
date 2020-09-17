import React from 'react';
import ReactDOM from 'react-dom';
import { mount } from 'enzyme';
import { MemoryRouter } from 'react-router';
import BookingPage from './AdminDashboard';
import WorkerPage from './AdminDashboard';
import App from './src/App';

jest.mock('firebase/app');

test('valid path for booking page', () => {
  const wrapper = mount(
    <MemoryRouter initialEntries={[ '/booking' ]}>
      <App/>
    </MemoryRouter>
  );
  expect(wrapper.find(BookingPage)).toHaveLength(1);
});

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/admin/worker' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(WorkerPage)).toHaveLength(1);
  });